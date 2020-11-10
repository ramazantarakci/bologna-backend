FROM nginx:alpine
 
COPY index.html /usr/share/nginx/html

RUN echo "$(hostname)" >> /usr/share/nginx/html/index.html
