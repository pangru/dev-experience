# Django
## 1. Http Request
* method: GET
  `request.GET['param_key']`
* method: POST
  * form request:
  ```
    content-type: x-www-form-urlencoded;
    request.POST = {
      'param_key': 'value'
    }
  ```
  * raw json request:
  ```
    content-type: application/json;
    # python2
    request.body = {
      'param_key': 'value'
    }

    # python3
    request.body = 'string stream...'
    request.body.decode('utf-8')
  ```
