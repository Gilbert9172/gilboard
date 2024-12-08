FROM mysql:9.1.0

COPY ./init.sql /docker-entrypoint-initdb.d/
COPY ./create-user.sql /docker-entrypoint-initdb.d/
COPY ./my.cnf /etc/mysql/mysql.conf.d/mysqld.cnf

EXPOSE 3306

CMD ["mysqld"]
