import random
import sys
import datetime
import time

def main():
    sys_argv = sys.argv
    batch_count = 5
    make_log_running_time = 60
    log_file_dir_path = "./"
    count = 0
    correct = 1
    
    if len(sys_argv) > 3:
        batch_count = int(sys_argv[1])
        make_log_running_time = int(sys_argv[2])
        log_file_dir_path = sys_argv[3]
    
    now_date = datetime.datetime.today()
    
    filename = "".join([log_file_dir_path, "taeyong", ".txt"])
    
    time.sleep(2)
    with open(filename, mode='rt', encoding='utf-8') as file_object:
        string = file_object.read()
        print(file_object.read())
    file_object.close()
            
    print("\nReading log end!")
    
    lst = string.split(':')
    lst[0] = "General2"
    lst[1] = "김태용"
    resultFile = "".join([log_file_dir_path,"result",".txt"])
    
    with open(resultFile, "a") as file_object:
        log_message = "{}:{}\n".format(
                    lst[0],lst[1])
        file_object.write(log_message)
    file_object.close()
    
    
if __name__ == "__main__":
    main()