import random
import sys
import datetime
import time
    
    
def main():
    sys_argv = sys.argv
    batch_count = 5
    make_log_running_time = 60
    log_file_dir_path = "./"
    
    if len(sys_argv) > 3:
        batch_count = int(sys_argv[1])
        make_log_running_time = int(sys_argv[2])
        log_file_dir_path = sys_argv[3]
    
    now_date = datetime.datetime.today()
    filename = "".join([log_file_dir_path, "taeyong", ".log"])
    
    with open(filename, mode='rt', encoding='utf-8') as file_object:
        print(file_object.read())
            
    print("\nReading log end!")
    
    
if __name__ == "__main__":
    main()