#!/bin/bash
echo '                       _____________________________________________________  '
echo '                      |                                                     | '
echo '             _______  |                                                     | '
echo '            / _____ | |                       AutoScheduler                 | '
echo '           / /(__) || |                                                     | '
echo '  ________/ / |OO| || |                                                     | '
echo ' |         |-------|| |                                                     | '
echo '(|         |     -.|| |_______________________                              | '
echo ' |  ____   \       ||_________||____________  |             ____      ____  | '
echo '/| / __ \   |______||     / __ \   / __ \   | |            / __ \    / __ \ |\'
echo '\|| /  \ |_______________| /  \ |_| /  \ |__| |___________| /  \ |__| /  \|_|/'
echo '   | () |                 | () |   | () |                  | () |    | () |   '
echo '    \__/                   \__/     \__/                    \__/      \__/    '
echo '                                                                              '

LOG_DIR="logs/"

function startApplication() {
  PID="$(ps aux | grep -e "java.*target.*autoscheduler.*App" | grep -v "grep" | tr -s ' ' | cut -d' ' -f2)"
  if [ -z "$PID" ]; then
    echo "[$(date)] Starting application ..."
    nohup java -classpath "target/scala-2.13/classes:lib/*" com.autoscheduler.Application -Dspring.profiles.active=sqlite \
      1>"$LOG_DIR/application-$(date +'%Y%m%d_%H%M%S').out" \
      2>"$LOG_DIR/application-$(date +'%Y%m%d_%H%M%S').err" &
    sleep 15
  else
    echo "[$(date)] Your application is apparently already running."
  fi
}

function showHelp() {
  echo "Usage:"
  printf "%8s%-25s - %s\n" "" "$0 --dataload" 'Performs data ingestion of data fetched via REST API.'
  printf "%8s%-25s - %s\n" "" "$0 --results" "Performs data analysis and shows the answer to the questions."
  printf "%8s%-25s - %s\n" "" "$0 --kill-app" "Kills current running application instance."
  printf "%8s%-25s - %s\n" "" "$0 [--help]" "Shows this help message"
}

function performAnalytics() {
  echo "[$(date)] Not yet implemented :("
}

function performDataIngestion() {
  echo "[$(date)] Performing data ingestion ..."
  curl -X GET http://127.0.0.1:8080/indicators
  echo ""
  echo "[$(date)] Done"'!'" Check the logfiles for details :)"
}

function killApplication() {
  echo "[$(date)] Killing application instance ..."
  PID="$(ps aux | grep -e "java.*target.*autoscheduler.*App" | grep -v "grep" | tr -s ' ' | cut -d' ' -f2)"
  if [ -z "$PID" ]; then
    echo "[$(date)] Your application is apparently not running."
  else
    /bin/kill -SIGTERM "$PID"
  fi
  echo "[$(date)] Done"'!'
}

if [ "$#" -lt 1 ]; then # Parameterless
  showHelp
elif [ "$#" -eq 1 ] && [ "$1" = "--help" ]; then # Show help
  showHelp
elif [ "$1" = "--dataload" ]; then # Querying API and persisting data ...
  startApplication
  performDataIngestion
elif [ "$1" = "--results" ]; then # Ensuring my new job ...
  performAnalytics
elif [ "$1" = "--kill-app" ]; then # Killing current application instance ...
  killApplication
else
  echo "Unrecognized option \"$1\""
  showHelp
  exit 1
fi
