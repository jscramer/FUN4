FROM node:10-alpine as build

RUN mkdir -p /home/node/app/node_modules && chown -R node:node /home/node/app

WORKDIR /home/node/app

ENV PATH ./front-end/SimpleCanFront/node_modules/.bin:$PATH

COPY ./front-end/SimpleCanFront/package.json ./
COPY ./front-end/SimpleCanFront/auth_config.json ./

RUN npm install
RUN npm install @vue/cli@3.7.0 -g

USER node

COPY --chown=node:node ./front-end/SimpleCanFront/src ./src

EXPOSE 8080

CMD ["npm", "run", "serve"]
