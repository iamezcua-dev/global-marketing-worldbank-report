#!/bin/bash
LOG_DIR="logs/"

safelyWipeableFiles() {
  echo "[$(date)] Deleting generated target folder and both, local SBT installation and their zip source package  ..."
  rm -rf sbt.zip target/ sbt/
}

showHelp() {
  echo "Usage:"
  printf "%8s%-25s - %s\n" "" "$0 [--also-logs]" 'Deletes sbt.zip file and target/ and sbt/ folders.'
  printf "%8s%-25s - %s\n\n" "" "" "Optionally, delete generated logs folder if the \`--also-logs\` flag is provided"
  printf "%8s%-25s - %s\n" "" "$0 --help" "Shows this help message"
}

if [ "$#" -eq 0 ]; then # Parameterless
  safelyWipeableFiles
elif [ "$#" -eq 1 ]; then
  if [ "$1" = "--help" ]; then # Show help
    showHelp
  elif [ "$1" = "--also-logs" ]; then # Also logs ...
    safelyWipeableFiles
    echo "[$(date)] Also deleting generated logs ..."
    rm -rf "$LOG_DIR"
  else
    echo "Unrecognized option \"$1\""
    showHelp
    exit 1
  fi
fi
echo "[$(date)] Done"'!'
