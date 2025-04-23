services:
  postgres:
    image: postgres:14
    container_name: miniapp_postgres
    restart: always
    environment:
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
      POSTGRES_DB: Karim_52_6391
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  mongodb:
    image: mongo:6
    container_name: miniapp_mongodb
    restart: always
    ports:
      - "27017:27017"
    volumes:
      - mongo_data:/data/db

  springboot-app:
    build: .
    container_name: miniapp_backend
    ports:
      - "6391:6391"
    depends_on:
      - postgres
      - mongodb
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/Karim_52_6391
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres
      SPRING_DATA_MONGODB_URI: mongodb://mongo:27017/ridesharing
    networks:
      - backend

networks:
  backend:
    driver: bridge

volumes:
  postgres_data:
  mongo_data:
