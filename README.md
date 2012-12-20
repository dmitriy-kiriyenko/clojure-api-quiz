# clojure-api-quiz

# Task

Using your choice of the programming language and additional libraries and/or frameworks, implement a single HTTP server with API endpoints that provide the following functionalities:

* A Fibonacci endpoint that accepts a number and returns the Fibonacci calculation for that number, and returns result in JSON format. Example:

```console
$ curl -s 'http://127.0.0.1:8080/fib/13'
{"response": 233}
$ curl -s 'http://127.0.0.1:8080/fib/12'
{"response": 144}
```

* An endpoint that fetches the Google homepage and returns the sha1 of the response message-body (HTTP body data).Example:

```console
$ curl -s 'http://127.0.0.1:8080/google-body'
{"response": "272cca559ffe719d20ac90adb9fc4e5716479e96"}
```

* Using some external storage of your choice (can be redis, memcache, sqlite, mysql, file system, etc), provide a means to store and then retrieve a value. Example:

```console
$ curl -d 'value=something' 'http://127.0.0.1:8080/store'
$ curl 'http://127.0.0.1:8080/store'
{"response": "something"}
```

# Solution

TODO
