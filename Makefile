.PHONY: local-env down logs

local-app-start:
	 mvn spring-boot:run -Dspring-boot.run.profiles=local-postgre

local-database-start:
	cd local-env; docker compose up -d --force-recreate


local-database-down:
	cd local-env; docker compose down -v;

local-database-logs:
	cd local-env; docker compose logs -f
