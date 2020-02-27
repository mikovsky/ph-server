#!/bin/bash

echo 'Setting NAME environment variable...'
set -x
NAME=$(mvn help:evaluate -Dexpression=project.name | grep "^[^\[]")
set +x

echo 'Setting VERSION environment variable...'
set -x
VERSION=$(mvn help:evaluate -Dexpression=project.version | grep "^[^\[]")
set +x

sudo cp "/target/${NAME}-${VERSION}.jar" "/mnt/zonedisk1/daily_artifacts"
