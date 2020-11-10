FROM nginx:alpine
 
COPY index.html /usr/share/nginx/html

COPY nginx.conf /etc/nginx/conf.d/default.conf

RUN echo "$(hostname)" >> /usr/share/nginx/html/index.html
