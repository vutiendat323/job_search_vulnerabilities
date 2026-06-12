#!/bin/sh
set -e

HOST="${DB_HOST:-mysql}"
PORT="${DB_PORT:-3306}"

echo "[wait-for-db] Waiting for $HOST:$PORT ..."
while ! (echo > /dev/tcp/$HOST/$PORT) 2>/dev/null; do
  echo "[wait-for-db] Not ready, retrying in 2s..."
  sleep 2
done

echo "[wait-for-db] $HOST:$PORT is open — giving MySQL 3s to finish init..."
sleep 3

echo "[wait-for-db] Starting app..."
exec "$@"
