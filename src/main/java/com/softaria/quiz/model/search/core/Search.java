package com.softaria.quiz.model.search.core;

import com.softaria.quiz.model.exception.BadRequestException;
import com.softaria.quiz.utils.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Search implements Serializable {

    private int offset = 0;
    private int limit = 10;
    private Map<String, String> aliases = MapUtils.createHashMap();
    private List<Filter> filters = CollectionUtils.createArrayList();
    private List<Sort> sorts = CollectionUtils.createArrayList();
    private List<String> lazyList = CollectionUtils.createArrayList();

    public void setPagination(Integer pageNumber, Integer pageSize) {
        int number = pageNumber != null ? pageNumber : 1;
        if (number < 1) {
            throw new BadRequestException(Messages.ERROR_PAGE_NUMBER_INVALID);
        }
        int size = pageSize != null ? pageSize : limit;
        if (size <= 0) {
            throw new BadRequestException(Messages.ERROR_PAGE_SIZE_INVALID);
        }
        limit = size;
        offset = (number - 1) * size;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        if (limit != null) {
            this.limit = limit;
        }
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        if (offset != null) {
            this.offset = offset;
        }
    }

    public void addFilter(Filter filter) {
        if (filter != null) {
            aliasingFilter(filter);
            filters.add(filter);
        }
    }

    public Map<String, String> getAliases() {
        return aliases;
    }

    public boolean hasFilters() {
        return !filters.isEmpty();
    }

    public List<Filter> getFilters() {
        return filters;
    }

    public void addLazyPath(String lazyPath) {
        lazyList.add(lazyPath);
    }

    public List<String> getLazyList() {
        return lazyList;
    }

    public List<Sort> getSorts() {
        return sorts;
    }

    public final void setSort(String sort) {
        setSort(sort, Boolean.FALSE);
    }

    public final void setSort(String sort, Boolean desc) {
        if (isValidSort(sort)) {
            resetSort();
            if (addCustomSort(sort, desc)) {
                return;
            }
            addSort(Sort.create(sort, desc));
        }
    }

    public final void addSort(String sort) {
        addSort(sort, Boolean.FALSE);
    }

    public final void addSort(String sort, Boolean desc) {
        if (isValidSort(sort)) {
            if (addCustomSort(sort, desc)) {
                return;
            }
            addSort(Sort.create(sort, desc));
        }
    }

    private boolean isValidSort(String sort) {
        return StringUtils.isNotEmpty(sort);
    }

    private boolean addCustomSort(String sort, Boolean desc) {
        return false;
    }

    private void resetSort() {
        sorts = new ArrayList<>();
    }

    private void setSort(Sort... sorts) {
        resetSort();
        for (Sort sort : sorts) {
            addSort(sort);
        }
    }

    private void addSort(Sort sort) {
        String property = sort.getProperty();
        if (property.contains(Format.DOT)) {
            sort.setProperty(aliasingProperty(property));
        }
        sorts.add(sort);
    }

    private void aliasingFilter(Filter filter) {
        if (filter.getFilters() != null && filter.getFilters().size() > 0) {
            filter.getFilters().forEach(this::aliasingFilter);
        }
        String property = filter.getProperty();
        if (property != null && property.contains(Format.DOT)) {
            filter.setProperty(aliasingProperty(property));
        }
    }

    private String aliasingProperty(String property) {
        int index = property.lastIndexOf(Format.DOT);
        if (index == -1) {
            return property;
        }
        return createAlias(property.substring(0, index)).concat(property.substring(index));
    }

    private String createAlias(String path) {
        int index = path.lastIndexOf(Format.DOT);
        if (index == -1) {
            aliases.put(path, path);
            return path;
        }
        String aliasName = path.replaceAll(Format.PATTERN_DOT, Format.UNDERSCORE);
        String aliasPath = createAlias(path.substring(0, index)).concat(path.substring(index));
        aliases.put(aliasName, aliasPath);
        return aliasName;
    }
}
