@echo on

cd bin
title JAVA ATM Project HNDIT20 - 0019 - Lakshitha Sankalpa!!&cls&echo ============================================================================&echo #Project: JAVA ATM Project HNDIT20&echo ============================================================================&echo ~~Copyright@Sankalpa&echo.&echo ============================================================================&echo.

start 0.mp3

javac C0.java
:tasklist
java C0

Taskkill /IM Music.UI.exe /F
Taskkill /IM wmplayer.exe /F
Taskkill /IM KMPlayer.exe /F
Taskkill /IM KMPlayer64.exe /F
Taskkill /IM KMPLoading.exe /F
Taskkill /IM wmplayer.exe /F
Taskkill /IM vlc.exe /F


del C0.class
del C1.class
del C2.class
del C3.class
del C4.class
del C5.class
del C6.class
del C7.class

del AccNo.txt
del Bal.txt
del deposite.txt
del NIC.txt
del pw.txt
del user_name.txt
del withdraw.txt

exit