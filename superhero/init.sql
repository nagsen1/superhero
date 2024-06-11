DROP DATABASE superhero_db IF EXISTS
CREATE DATABASE superhero_db;
CREATE USER superhero WITH PASSWORD 'superhero';
GRANT ALL PRIVILEGES ON DATABASE superhero_db TO superhero;


CREATE TABLE "superhero" (
  "id" serial PRIMARY KEY,
  "created_at" timestamp,
  "updated_at" timestamp,
  "alias" varchar(100) NOT NULL,
  "name" varchar(100) NOT NULL,
  "origin" text
);

CREATE TABLE "power" (
  "id" serial PRIMARY KEY,
  "superhero_id" int,
  "power_name" varchar(100) NOT NULL
);

CREATE TABLE "weapon" (
  "id" serial PRIMARY KEY,
  "superhero_id" int,
  "weapon_name" varchar(100)
);

CREATE TABLE "association" (
  "id" serial PRIMARY KEY,
  "superhero_id" int,
  "association_name" varchar(100)
);

ALTER TABLE "superhero" ADD FOREIGN KEY ("id") REFERENCES "power" ("superhero_id") ON DELETE CASCADE;

ALTER TABLE "superhero" ADD FOREIGN KEY ("id") REFERENCES "weapon" ("superhero_id") ON DELETE CASCADE;

ALTER TABLE "superhero" ADD FOREIGN KEY ("id") REFERENCES "association" ("superhero_id") ON DELETE CASCADE;
