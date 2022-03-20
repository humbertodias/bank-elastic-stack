#!/bin/sh

echo "US
New York
New York City
Bouncy Castles, Inc.
Ministry of Water Slides
*
admin@your_domain.com
" | openssl req -x509 -nodes -days 365 -newkey rsa:2048 -keyout /etc/nginx/private.pem -out /etc/nginx/public.pem