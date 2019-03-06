--
-- PostgreSQL database dump
--

-- Dumped from database version 11.1
-- Dumped by pg_dump version 11beta2

-- Started on 2018-12-23 03:37:50

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 199 (class 1259 OID 24604)
-- Name: cat; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.cat (
    id integer NOT NULL,
    name text NOT NULL,
    age integer NOT NULL
);


ALTER TABLE public.cat OWNER TO postgres;

--
-- TOC entry 198 (class 1259 OID 24602)
-- Name: cat_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.cat_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.cat_id_seq OWNER TO postgres;

--
-- TOC entry 2183 (class 0 OID 0)
-- Dependencies: 198
-- Name: cat_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.cat_id_seq OWNED BY public.cat.id;


--
-- TOC entry 197 (class 1259 OID 24596)
-- Name: user; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."user" (
    id integer NOT NULL,
    name text NOT NULL,
    age integer NOT NULL,
    admin boolean NOT NULL,
    balance double precision NOT NULL,
    creationdate date NOT NULL
);
ALTER TABLE ONLY public."user" ALTER COLUMN id SET STATISTICS 0;
ALTER TABLE ONLY public."user" ALTER COLUMN name SET STATISTICS 0;
ALTER TABLE ONLY public."user" ALTER COLUMN age SET STATISTICS 0;
ALTER TABLE ONLY public."user" ALTER COLUMN admin SET STATISTICS 0;


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 196 (class 1259 OID 24594)
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.user_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- TOC entry 2184 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.user_id_seq OWNED BY public."user".id;


--
-- TOC entry 2048 (class 2604 OID 24607)
-- Name: cat id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cat ALTER COLUMN id SET DEFAULT nextval('public.cat_id_seq'::regclass);


--
-- TOC entry 2047 (class 2604 OID 24599)
-- Name: user id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user" ALTER COLUMN id SET DEFAULT nextval('public.user_id_seq'::regclass);


--
-- TOC entry 2177 (class 0 OID 24604)
-- Dependencies: 199
-- Data for Name: cat; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.cat (id, name, age) FROM stdin;
1659	cat1	1
1660	cat2	2
1661	cat3	3
1662	cat4	4
1663	cat5	5
1664	cat6	6
1665	cat7	7
1666	cat8	8
1667	cat9	9
1668	cat10	10
1669	cat11	11
1670	cat12	12
1671	cat13	13
1672	cat14	14
1673	cat15	15
1674	cat16	16
1675	cat17	17
1676	cat18	18
1677	cat19	19
1678	cat20	20
\.


--
-- TOC entry 2175 (class 0 OID 24596)
-- Dependencies: 197
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public."user" (id, name, age, admin, balance, creationdate) FROM stdin;
146	Victor	23	f	22.23	2018-12-22
\.


--
-- TOC entry 2185 (class 0 OID 0)
-- Dependencies: 198
-- Name: cat_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.cat_id_seq', 1678, true);


--
-- TOC entry 2186 (class 0 OID 0)
-- Dependencies: 196
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.user_id_seq', 156, true);


--
-- TOC entry 2052 (class 2606 OID 24609)
-- Name: cat cat_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.cat
    ADD CONSTRAINT cat_pkey PRIMARY KEY (id);


--
-- TOC entry 2050 (class 2606 OID 24601)
-- Name: user user_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."user"
    ADD CONSTRAINT user_pkey PRIMARY KEY (id);


-- Completed on 2018-12-23 03:37:54

--
-- PostgreSQL database dump complete
--

