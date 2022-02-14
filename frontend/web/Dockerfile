FROM node:16 AS build

# Create app directory
WORKDIR /app

# Bundle app source
COPY . .

# Dependencies
RUN yarn install

EXPOSE 3000
CMD [ "yarn", "run", "start"]
