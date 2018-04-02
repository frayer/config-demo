docker rmi -f $(docker images -q -f label=name=config-demo)
