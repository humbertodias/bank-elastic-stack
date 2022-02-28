FROM mongo
HEALTHCHECK --interval=30s --timeout=3s --retries=3 CMD mongo --eval "db.adminCommand('ping')" || exit 1