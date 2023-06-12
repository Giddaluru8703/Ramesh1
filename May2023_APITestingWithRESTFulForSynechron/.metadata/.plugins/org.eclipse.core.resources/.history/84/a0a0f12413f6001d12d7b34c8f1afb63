Feature: validate GoogleMap API

Scenario: verify if place is being successfully added using AddplaceAPI

Given Add place PayLoad
When user calls AddPlaceAPI with POST http request
Then the API call got success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"