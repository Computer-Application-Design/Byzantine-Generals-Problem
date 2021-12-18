FROM python:3.6
RUN mkdir -p /app
RUN mkdir -p /app/input
WORKDIR /app
COPY . /app
ENV NAME Make_Log_File
CMD ["python", "general.py", "5", "60", "/app/input/"]