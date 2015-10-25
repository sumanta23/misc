#!/usr/bin/env python

import os
import subprocess
import sys

wd=sys.argv[1]

exelist = ['before_install','install','script']

def getCommands(dir):
    file=dir+'/.travis.yml'
    with open(file) as f:
        content = f.readlines()
        return content


lines=getCommands(wd)

for line in lines:
    key=line.split(':')[0]
    value=line.split(':')[1]
    value=value.rstrip('\n').rstrip('\r')
    if key in exelist:
        value='cd '+wd+'; '+value
        print value
        p = subprocess.call(value, shell=True)



