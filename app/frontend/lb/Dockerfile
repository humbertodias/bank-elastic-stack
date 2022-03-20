FROM nginx
COPY nginx.conf /etc/nginx
COPY create-cert.sh /etc/nginx
RUN sh /etc/nginx/create-cert.sh
EXPOSE 3005 3006
HEALTHCHECK --interval=30s --timeout=3s --retries=3 CMD curl -f http://localhost:3005/health || exit 1
CMD ["nginx", "-g", "daemon off;"]