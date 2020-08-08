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
SBT_ZIP="sbt.zip"

if [ ! -d "$LOG_DIR" ]; then
  mkdir -p "$LOG_DIR"
fi

if [ -z "$SBT_HOME" ]; then
  echo "[$(date)] SBT home not set. \`:{"
  if [ ! -d "sbt/" ]; then
    echo "[$(date)] Getting SBT ..."
    wget -O $SBT_ZIP https://piccolo.link/sbt-1.3.4.zip 2>"$LOG_DIR/sbt-download_$(date +'%Y%m%d_%H%M%S').err"
    echo "[$(date)] Unpacking SBT to current directory ..."
    unzip -qo $SBT_ZIP
  fi
  SBT_HOME="sbt/"
fi

echo "[$(date)] Current SBT_HOME=$SBT_HOME"
echo "[$(date)] Compiling and packaging application ..."
"$SBT_HOME"/bin/sbt --batch ";clean ;compile ;universal:packageBin ;assembly" \
  1>"$LOG_DIR/source-compilation_$(date +'%Y%m%d_%H%M%S').out" \
  2>"$LOG_DIR/source-compilation_$(date +'%Y%m%d_%H%M%S').err"

echo "[$(date)] Preparing provided libraries ..."
unzip -qo target/universal/global-marketing-worldbank-report-*.zip -d libraries/
rm -rf lib/
mv -f libraries/global-marketing-worldbank-report-*/lib .
rm -rf libraries/

echo "[$(date)] Compilation and workspace done"'!'
