#! /bin/bash

startDate=$1
endDate=$2

if [ ! -f ./global.properties ] ; then
    echo "File not found global.properties"
    exit 1
elif [ ! -f ./bundle.properties ] ; then
    echo "File not found bundle.properties"
    exit 1
elif [ $# -lt 1 ] ; then
    echo "Correct Usage: $0 <startDate:yyyyMMdd> [<endDate:yyyyMMdd>]"
    exit 1
else
    startDate=$(date +%Y-%m-%d -d ${startDate})
    if [ "${endDate}" = "" ] ; then
        endDate=$(date +%Y-%m-%d -d 20500101)
    else
        endDate=$(date +%Y-%m-%d -d ${endDate})
    fi

    cat ./global.properties ./bundle.properties >> ./merge.properties

    oozieService=http://hdm3.hdp.local:11000/oozie

    oozie job -oozie ${oozieService} -config ./merge.properties -run -DstartDate=${startDate} -DendDate=${endDate}
fi
