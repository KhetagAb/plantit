# Step 5 - Database setup

### Description

Postgresql database is used.

There are few .sql scripts, that create default table "clients", then migrate column "client_type" from enum to another table.

Between table creating and migration dummy data is loaded.

For migration [liquibase](https://www.liquibase.org) framework is used.

### Project building:

- [Download dummies file](https://drive.google.com/file/d/16ysrOksARNGwpeQ6_O-4HhJj-4iz8ecg/view?usp=sharing
  ) for database before docker image build and place it [here](../landscape-service/src/main/resources/db/dummy/lfs) (replace if needed)
- Use dev [README.md](../dev/README.md) **ONLY** to build docker images.
- Use k8s [README.md](../dev/k8s/README.md) to set up cluster and create PostreSQL persistence storage (also build docker containers!).
  - Pay attention to [Service](../dev/k8s/postgres-service.yaml), that expose PostgreSQL as headless service.
    - There are [dnsutils pod](../dev/k8s/admin/dns/dnsutils.yaml) to look up DNS in the cluster.
- Connect to database to see result
### Result
- Table is created as migration, client_type column in the table is migrated.
- Video is attached

