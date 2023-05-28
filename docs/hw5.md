# Step 5 - Database setup

### Description

Postgresql database is used.

There are few .sql scripts, that create default table "clients", then migrate column "client_type" from enum to another table.

Between table creating and migration dummy data is loaded.

For migration [liquibase](https://www.liquibase.org) framework is used.

### Project building:

- Use dev [README.md](../dev/README.md) **ONLY** to build docker images.
- Use k8s [README.md](../dev/k8s/README.md) to set up cluster and create PostreSQL persistence storage (also build docker containers!).
- Pay attention to [Service](../dev/k8s/postgres-service.yaml), that expose PostgreSQL at 30400 port to localhost (where k8s is started).
  - There are [dnsutils pod](../dev/k8s/admin/dns/dnsutils.yaml) to look up DNS in the cluster.

https://drive.google.com/file/d/16ysrOksARNGwpeQ6_O-4HhJj-4iz8ecg/view?usp=sharing
### Result

