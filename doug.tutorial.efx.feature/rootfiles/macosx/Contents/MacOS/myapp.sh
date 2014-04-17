#!/bin/sh                                                                       
appRoot=`dirname $0`/../..
launcher=`ls -rt $appRoot/plugins/org.eclipse.equinox.launcher_*.jar | tail -1`
java \
	-Dorg.osgi.framework.bundle.parent=ext \
	-Xdock:icon=$appRoot/Contents/Resources/Eclipse.icns \
	-jar $launcher
