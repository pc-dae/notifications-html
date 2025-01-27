#!/usr/bin/env bash

# Utility building the docker image
# Version: 1.0
# Author: Paul Carlton (mailto:paul.carlton@dae.mn)

set -euo pipefail

function usage()
{
    echo "usage ${0} [--debug] [--version <version>]" >&2
    echo "This script will build and push the docker image" >&2
}

function args() {
  APP_NAME="notifications-html"
  export VERSION="${VERSION:-}"

  arg_list=( "$@" )
  arg_count=${#arg_list[@]}
  arg_index=0
  while (( arg_index < arg_count )); do
    case "${arg_list[${arg_index}]}" in
          "--version") (( arg_index+=1 ));VERSION=${arg_list[${arg_index}]};;
          "--debug") set -x;;
               "-h") usage; exit;;
           "--help") usage; exit;;
               "-?") usage; exit;;
        *) if [ "${arg_list[${arg_index}]:0:2}" == "--" ];then
               echo "invalid argument: ${arg_list[${arg_index}]}" >&2
               usage; exit
           fi;
           break;;
    esac
    (( arg_index+=1 ))
  done
}

args "$@"

./mvnw clean package

docker build -t paulcarltondae/$APP_NAME:$VERSION .
docker push paulcarltondae/$APP_NAME:$VERSION
