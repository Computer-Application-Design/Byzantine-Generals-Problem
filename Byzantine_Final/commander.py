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
    filename = "".join([log_file_dir_path, "taeyong", ".txt"])
    
    with open(filename, "w") as file_object:
        log_message = "{}:{}\n".format("Commander","김태용")
        file_object.write(log_message)
            



    time.sleep(5)
    filename2 = "".join([log_file_dir_path, "result",".txt"])
    fault = 0 # Fault메시지 갯수 세기 위해서
    number = 0 # General 갯수
    f = open(filename2,"rt",encoding='utf-8')
    while True:
        lst = f.readline().split(':')
        if(lst[1]=="홍길동\n"):
            fault = fault + 1
            number = number + 1
            log_message = "<{} : {}>\n".format(lst[0],'홍길동')
            print(log_message)
        else:
            number = number + 1
            log_message = "<{} : {}>\n".format(lst[0],'김태용')
            print(log_message)
        if(number == 4):
            break
    
    if(number < (3*fault) + 1):
        print("합의 불가능")
    else:
        print("합의 가능")
        
    f.close()

    
if __name__ == "__main__":
    main()