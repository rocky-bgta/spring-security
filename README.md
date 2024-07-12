# spring-security

Simple json payload to create user:
{
"username": "tuli",
"password": "tuli",
"roleList": [
{
"roleName":"ROLE_USER"
}

]
}

# curl for refresh token:
curl --location 'http://localhost:8080/refreshtoken' \
--header 'isRefreshToken: true' \
--header 'Authorization: ••••••' \
