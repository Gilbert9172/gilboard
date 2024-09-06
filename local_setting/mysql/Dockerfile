FROM mysql:latest

COPY ./init.sql /docker-entrypoint-initdb.d/
COPY ./my.cnf /etc/mysql/mysql.conf.d/mysqld.cnf

EXPOSE 3306

CMD ["mysqld"]