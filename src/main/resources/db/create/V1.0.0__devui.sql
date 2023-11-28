
    create sequence gift_id_seq start with 1 increment by 1;

    create table Gift (
        id bigint not null,
        name varchar(255),
        primary key (id)
    );
