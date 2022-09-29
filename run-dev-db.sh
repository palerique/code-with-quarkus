#!/bin/bash

docker run --name postgres-dev \
    -p 5432:5432 \
    -e POSTGRES_DB=tickit \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=postgres123 \
    -d postgres:14.2-alpine3.15

