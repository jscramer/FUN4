FROM node:10-alpine as build

RUN mkdir -p /home/node/app/node_modules && chown -R node:node /home/node/app

WORKDIR /home/node/app

COPY ./Koffie/client/package.json ./

RUN npm install
RUN npm install @vue/cli@3.7.0 -g

USER node

COPY --chown=node:node ./Koffie/client/src ./src

EXPOSE 8080

CMD ["npm", "run", "serve"]
