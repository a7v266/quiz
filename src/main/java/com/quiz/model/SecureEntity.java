package com.quiz.model;

import com.quiz.service.EnvironmentService;
import com.quiz.utils.Messages;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@MappedSuperclass
public class SecureEntity extends BaseEntity {

    public static final String LOCAL_USER_ID = "localUserId";

    @Column(name = "local_user_id", updatable = false)
    @NotNull(message = Messages.ERROR_LOCAL_USER_ID_EMPTY)
    private Long localUserId;

    public SecureEntity() {
        localUserId = EnvironmentService.getLocalUserId();
    }

    public boolean isAccessAllowed(LocalUser localUser) {
        return localUser != null && Objects.equals(localUser.getId(), localUserId);
    }

    public boolean isAccessDenied(LocalUser localUser) {
        return localUser == null || localUserId == null || !Objects.equals(localUser.getId(), localUserId);
    }

    public Long getLocalUserId() {
        return localUserId;
    }

    public void setLocalUserId(Long localUserId) {
        this.localUserId = localUserId;
    }
}
