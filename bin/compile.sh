#!/bin/bash
LOG_DIR="logs/"
SBT_ZIP="sbt.zip"

if [ ! -d "$LOG_DIR" ]; then
  mkdir -p "$LOG_DIR"
fi

if [ -z "$SBT_HOME" ]; then
  echo "[$(date)] SBT home not set. Getting SBT ..."
  wget -O $SBT_ZIP https://piccolo.link/sbt-1.3.4.zip 2>"$LOG_DIR/sbt-download_$(date +'%Y%m%d_%H%M%s').err"
  unzip -qo $SBT_ZIP
  SBT_HOME="./sbt/"
fi

echo "[$(date)] Current SBT_HOME=$SBT_HOME"
echo "[$(date)] Compiling and packaging application ..."
"$SBT_HOME"/bin/sbt --batch ";clean ;compile ;assembly" \
  1>"$LOG_DIR/source-compilation_$(date +'%Y%m%d_%H%M%s').out"
  2>"$LOG_DIR/source-compilation_$(date +'%Y%m%d_%H%M%s').err"

