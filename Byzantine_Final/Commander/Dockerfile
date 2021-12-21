FROM python:3.8-slim-buster
RUN mkdir -p /app
RUN mkdir -p /app/input
WORKDIR /app
COPY . /app
ENV NAME Make_Log_File
CMD ["python", "commander.py", "5", "60", "/app/input/"]