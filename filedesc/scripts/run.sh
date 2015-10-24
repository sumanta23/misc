#!/bin/bash

usage(){
	echo "Usage: $0 <Absolute-path> <Username> <Password>"
	exit 1
}

case "$1" in
        "local")
        java -cp ":" -jar fileliser.jar 
        ;;
        "smb")
        
        ;;
        "nfs")
        
        ;;
        "ssh")
        
        ;;
        *)
        usage
        ;;
esac
exit 0
       