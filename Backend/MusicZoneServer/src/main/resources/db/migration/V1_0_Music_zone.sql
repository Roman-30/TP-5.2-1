create table public.music
(
    id        serial
        primary key,
    copyright varchar(255),
    genre     varchar(255),
    link      varchar(255),
    name      varchar(255)
);

alter table public.music
    owner to postgres;

create table public.person
(
    id        serial
        primary key,
    email     varchar(255),
    name      varchar(255),
    nick_name varchar(255),
    password  varchar(255),
    phone     varchar(255),
    surname   varchar(255)
);

alter table public.person
    owner to postgres;

create table public.playlist
(
    id          serial
        primary key,
    description varchar(255),
    name        varchar(255)
);

alter table public.playlist
    owner to postgres;

create table public.music_in_playlist
(
    playlist_id integer not null
        constraint fkc0ap1qp5gnqkejw3j9wula01u
            references public.playlist,
    music_id    integer not null
        constraint fkl5ul2m6v2o31i8w90ee4ryswe
            references public.music,
    primary key (music_id, playlist_id)
);

alter table public.music_in_playlist
    owner to postgres;

create table public.user_playlist
(
    playlist_id integer not null
        constraint fk7k6xercebs1wg014xb49hw3h0
            references public.playlist,
    user_id     integer not null
        constraint fk6k3h7xqyc1d03m13s8apy3efj
            references public.person,
    primary key (user_id, playlist_id)
);

alter table public.user_playlist
    owner to postgres;

create table public.user_role
(
    user_id integer not null
        constraint fks92q0x8xfwil0ac1k3ucsnr93
            references public.person,
    roles   varchar(255)
);

alter table public.user_role
    owner to postgres;
