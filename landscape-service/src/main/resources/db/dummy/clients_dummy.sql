CREATE OR REPLACE FUNCTION generate_email() RETURNS text AS
$$
BEGIN
    return md5(random()::text)::text || '@example.com';
END;
$$
    LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION generate_login() RETURNS text AS
$$
BEGIN
    return md5(random()::text)::text;
END;
$$
    LANGUAGE plpgsql;

SELECT CASE
           WHEN random() <= 0.25
               THEN 'rancher'::client_type
           ELSE 'handyman'::client_type
        END AS client_type,
       generate_login() AS login,
       generate_email() AS email,
       '7' || LPAD(sub::text, 11, '0') AS phone
FROM generate_series(1, 3.14E6) sub;
