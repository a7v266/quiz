# Quiz

## API specification

### Environment API
| Command | Path | Description | 
| --- | --- | --- |
| GET | /api/environment | Get environment |
| PUT | /api/environment | Update environment |

#### Environment
| Field | Type | Description |
| --- | --- | --- |
| lisPersonNameFamily | string | A last name of person that is performing a launch.
| lisPersonNameGiven | string | A first name of person that is performing a launch.
| personRole | string | This is a role of person that is performing a launch. Role values are "Instructor" and "Learner".
| launchView | string | This is a view which should be open at startup. View values are "Problems" and "Solution".
| resourceLink | ResourceLink | A reference to current resource link.

##### Update parameters
| Parameter | Type | Required | Updatable | Description |
| --- | --- | --- | --- | --- |
| resourceLinkId | number | no | yes | Natural number. |

### Problem API
| Command | Path | Description | 
| --- | --- | --- |
| GET | /api/problems/ | Get problems |
| GET | /api/problems/{id} | Get problem number {id} | 
| POST | /api/problems | Create new problem
| PUT | /api/problems/{id} | Update problem number {id}
| DELETE | /api/problems/{id} | Delete problem number {id}

#### Problem
| Field | Type | Description |
| --- | --- | --- |
| id | number | A synthetic key. |
| resourceLink | ResourceLink | A reference to resource link. |
| topicId | string | This is an unique identifier for the topic. |
| problemDescription | string | A problem description. | 
| problemComplexity | number | This real number describes the complexity of the problem. |
| expectedAnswers | Answer[] | A list of expected answers, which will be compared student answers. | 

#### Answer
| Field | Type | Description |
| --- | --- | --- |
| answerValue | string | This is expected answer. |
| answerStatus | number | A answer status: 1 - unchecked, 2 - valid, 3 - invalid. |

##### Create and update parameters
##### Problem
| Parameter | Type | Required | Updatable | Description |
| --- | --- | --- | --- | --- |
| topicId | string | yes | yes | Not empty and max 255 chars. |
| problemDescription | string | yes | yes | Not empty. |
| problemComplexity | number | yes | yes | Real number and not null. |
| expectedAnswers | Answer[] | yes | yes | Not empty. |
##### Answer
| Parameter | Type | Required | Updatable | Description |
| --- | --- | --- | --- | --- |
| answerValue | string | yes | yes | Not empty and not repeated. |


### Resource Link API
| Command | Path | Description | 
| --- | --- | --- |
| GET | /api/resource-links/ | Get resource links |
| GET | /api/resource-links/{id} | Get resource link number {id} | 
| POST | /api/problems | Create new resource link
| PUT | /api/problems/{id} | Update resource link number {id}
| DELETE | /api/problems/{id} | Delete resource link number {id}

#### Resource Link
| Field | Type | Description | 
| --- | --- | --- | 
| id | number | A synthetic key. |
| context | Context | A reference to context. |
| resourceLinkId | string | This is an opaque unique identifier that the TC guarantees will be unique within the TC for every placement of the link.   If the tool / activity is placed multiple times in the same context, each of those placements will be distinct. This value will also change if the item is exported from one system or context and imported into another system or context.  This parameter is required. |
| resourceLinkTitle | string | A title for the resource. This is the clickable text that appears in the link. This parameter is recommended. |
| resourceLinkDescription | string | A plain text description of the link’s destination, suitable for display alongside the link. Typically no more than several lines long. This parameter is optional. | 

##### Create and update parameters
| Parameter | Type | Required | Updatable | Description |  
| --- | --- | --- |  --- | --- |
| contextId | number |  yes | no | Natural number and not null. |
| resourceLinkId | string | yes | no | Not empty and max 255 chars. |
| resourceLinkTitle | string | no | yes | Max 255 chars. |
| resourceLinkDescription | string | no | yes | Max 255 chars. |


### Context API
| Command | Path | Description | 
| --- | --- | --- |
| GET | /api/contexts/ | Get contexts |
| GET | /api/contexts/{id} | Get context number {id} | 
| POST | /api/contexts | Create new context
| PUT | /api/contexts/{id} | Update context number {id}
| DELETE | /api/contexts/{id} | Delete context number {id}

#### Context
| Field | Type | Description |
| --- | --- | --- |
| id | number | A synthetic key |
| contextId | string | This is an opaque identifier that uniquely identifies the context that contains the link being launched. This parameter is required. |
| contextTitle | string | A title of the context – it should be about the length of a line. |
| contextLabel | string | A label for the context – intended to fit in a column. | 
| contextType | string | This string is a comma-separated list of URN values that identify the type of context.  At a minimum, the list MUST include a URN value drawn from the LIS vocabulary (see Appendix A). The assumed namespace of these URNs is the LIS vocabulary so TCs can use the handles when the intent is to refer to an LIS context type.  If the TC wants to include a context type from another namespace, a fully-qualified URN should be used.| 

##### Create and update parameters
| Parameter | Type | Required | Updatable | Description |  
| --- | --- | --- | --- | --- |
| contextId | string |  yes | no | Not empty and max 255 chars. |
| contextTitle | string |  no | yes | Max 255 chars. |
| contextLabel | string |  no | yes | Max 255 chars. |
| contextLabel | string |  no | yes | Max 255 chars. |
| contextType | string |  no | yes | Max 255 chars. |




#### Examples

##### Create new Problem example
Request 
```
POST /problems/
{
  "topicId": "createdTopicId",
  "problemDescription": "createdProblemDescription",
  "problemComplexity": 1.0,
  "expectedAnswers": [
    {
      "answerValue": "createdAnswerValue1"
    },
    {
      "answerValue": "createdAnswerValue2"
    },
    {
      "answerValue": "createdAnswerValue3"
    }
  ]
}
```
Response
```
{
  "id": 4,
  "resourceLink": {
    "id": 11
  },
  "topicId": "createdTopicId",
  "problemDescription": "createdProblemDescription",
  "problemComplexity": 1.0,
  "expectedAnswers": [
    {
      "answerValue": "createdAnswerValue1",
      "answerStatus": 1
    },
    {
      "answerValue": "createdAnswerValue2",
      "answerStatus": 1
    },
    {
      "answerValue": "createdAnswerValue3",
      "answerStatus": 1
    }
  ]
}
```
##### Update Problem number 1 example
Request
```
PUT /api/problem/1
{
  "topicId": "updatedTopicId",
  "problemDescription": "updatedProblemDescription",
  "problemComplexity": 2.0,
  "expectedAnswers": [
    {
      "answerValue": "updatedAnswerValue1"
    },
    {
      "answerValue": "updatedAnswerValue2"
    }
  ]
}
```
Response
```
{
  "id": 1,
  "resourceLink": {
    "id": 11
  },
  "topicId": "updatedTopicId",
  "problemDescription": "updatedProblemDescription",
  "problemComplexity": 2.0,
  "expectedAnswers": [
    {
      "answerValue": "updatedAnswerValue1",
      "answerStatus": 1
    },
    {
      "answerValue": "updatedAnswerValue2",
      "answerStatus": 1
    }
  ]
}
```
##### Get problems example
Request
```
GET /problems?pageNumber=1&pageSize=3
```

Response
```
{
  "items": [
    {
      "id": 1,
      "resourceLink": {
        "id": 11
      },
      "topicId": "topicId1001",
      "problemDescription": "problemDescription1",
      "problemComplexity": 1.00,
      "expectedAnswers": [
        {
          "answerValue": "answerValue11",
          "answerStatus": 1
        },
        {
          "answerValue": "answerValue12",
          "answerStatus": 2
        },
        {
          "answerValue": "answerValue13",
          "answerStatus": 3
        }
      ]
    },
    {
      "id": 2,
      "resourceLink": {
        "id": 11
      },
      "topicId": "topicId1001",
      "problemDescription": "problemDescription2",
      "problemComplexity": 1.00,
      "expectedAnswers": [
        {
          "answerValue": "answerValue21",
          "answerStatus": 2
        },
        {
          "answerValue": "answerValue22",
          "answerStatus": 2
        },
        {
          "answerValue": "answerValue23",
          "answerStatus": 2
        }
      ]
    },
    {
      "id": 3,
      "resourceLink": {
        "id": 11
      },
      "topicId": "topicId1002",
      "problemDescription": "problemDescription2",
      "problemComplexity": 0.59,
      "expectedAnswers": [
        {
          "answerValue": "answerValue21",
          "answerStatus": 1
        },
        {
          "answerValue": "answerValue22",
          "answerStatus": 1
        },
        {
          "answerValue": "answerValue23",
          "answerStatus": 1
        }
      ]
    }
  ],
  "totalCount": 4
}
```
