cd $(dirname $0)
rm -r "api-mobile"
openapi-generator generate -i "thenewsapi.yaml" -g kotlin --library multiplatform -o "api-mobile"
