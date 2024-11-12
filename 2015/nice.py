import re
def pair(word: str) -> bool:
    pac = []

    for i in range(0, len(word)-1 ):
        letters = word[i:i+2]
        overlap = word[i+1:i+2]
        # print(overlap)
        print(letters, overlap , "test")
        
            # print('repeated', letters,word) 
        if letters in pac and overlap not in letters:
            print("true")
            return True
        pac.append(letters)
    return False


def has_two_non_overlapping_pairs(s):
    # Use regex to find any two-character sequence that appears at least twice, without overlapping
    return bool(re.search(r'(\w\w).*\1', s))





def same(s: str) -> bool:
    for i in range(0, len(s)-2):

        if s[i] == s[i+2]:
            return True


    # print(count)
with open('words.txt') as f:
    count = 0
    for line in f:

        line = line.strip()
        # print(line, end='')
        if(has_two_non_overlapping_pairs(line) and same(line)):
            count += 1
            print(line)
        # if(pair(line)!= False):

        #     arr =[] 
        #     arr += pair(line)
            # list_count(arr)
    print(count) 