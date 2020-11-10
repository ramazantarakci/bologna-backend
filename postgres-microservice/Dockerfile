FROM postgres:latest
ENV POSTGRES_USER bologna_admin
ENV POSTGRES_PASSWORD bologna_admin
ENV POSTGRES_DB bologna_db 
COPY init.sql /docker-entrypoint-initdb.d/
