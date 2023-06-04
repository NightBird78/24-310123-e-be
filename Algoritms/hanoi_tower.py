import time
import datetime


class HanoiTower:
    def __init__(self, disc_count: int):
        self.disc_count = disc_count

        self.pin1 = [x for x in range(1, disc_count + 1)]
        self.pin2 = []
        self.pin3 = []

        self.pin_dict = {
            1: self.pin1,
            2: self.pin2,
            3: self.pin3
        }

        self.iterations = 0

    def __str__(self):  # вывод получилось сделать довольно интерестным образом
        max_num = 2 * self.disc_count + 3

        # в начале заполнить пустоту нулями
        pin1 = [0 for _ in range(self.disc_count - len(self.pin1))]
        pin2 = [0 for _ in range(self.disc_count - len(self.pin2))]
        pin3 = [0 for _ in range(self.disc_count - len(self.pin3))]

        pin1.extend(self.pin1)
        pin2.extend(self.pin2)
        pin3.extend(self.pin3)

        for _ in range(self.disc_count):  # с помощью fString нарисовать пирамидки
            n1 = (2 * pin1[_] + 3 if pin1[_] > 0 else 0)
            n2 = (2 * pin2[_] + 3 if pin2[_] > 0 else 0)
            n3 = (2 * pin3[_] + 3 if pin3[_] > 0 else 0)

            print(('  {:^' + str(max_num) + '}').format("━" * n1), end="")
            print(('  {:^' + str(max_num) + '}').format("━" * n2), end="")
            print(('  {:^' + str(max_num) + '}').format("━" * n3), end="")
            print()

        print("═" * (max_num * 3 + 8))
        # что удивительно это забрало наибольше времени (дебаг визуала)
        return ''

    def move_disc(self, pattern: tuple[int, int]):
        if len(self.pin_dict[pattern[1]]) == 0:
            # print("if 1")
            # print(pattern[0], "move to", pattern[1])
            self.pin_dict[pattern[1]].append(self.pin_dict[pattern[0]].pop(0))
        elif len(self.pin_dict[pattern[0]]) == 0:
            # print("if 2")
            # print(pattern[1], "move to", pattern[0])
            self.pin_dict[pattern[0]].append(self.pin_dict[pattern[1]].pop(0))
        elif self.pin_dict[pattern[1]][0] < self.pin_dict[pattern[0]][0]:  # =====
            # print("if 3")
            # print(pattern[1], "move to", pattern[0])
            self.pin_dict[pattern[0]].insert(0, self.pin_dict[pattern[1]].pop(0))
        elif self.pin_dict[pattern[1]][-1] > self.pin_dict[pattern[0]][-1]:  # =====
            # print("if 4")
            # print(pattern[1], "move to", pattern[0])
            self.pin_dict[pattern[1]].insert(0, self.pin_dict[pattern[0]].pop(0))
        else:
            # print("else")
            # print(pattern[0], "move to", pattern[1])
            self.pin_dict[pattern[1]].insert(0, self.pin_dict[pattern[0]].pop(0))

    def move_all_as_cycle(self, out=False):
        if self.disc_count % 2 == 0:
            patterns = ((1, 2), (1, 3), (2, 3))
        else:
            patterns = ((1, 3), (1, 2), (2, 3))

        n = 0
        count = 0
        while True:
            if sum(self.pin1) == 0 and sum(self.pin2) == 0 and sum(self.pin3) > 0:
                return f"iterations = {self.iterations}"

            # time.sleep(1)
            self.move_disc(patterns[n])

            if n > 1:
                n = -1
            n += 1
            count += 1
            self.iterations += 1

            if out:
                print(self)

    def move_all_as_recursion(self, out=False):
        def hanoi_recursion(q:int, _from:list, to:list, buf:list):
            if out:
                print(self)
            if q == 0:
                return q, _from, to, buf

            hanoi_recursion(q - 1, _from, buf, to)

            to.insert(0, _from.pop(0))

            hanoi_recursion(q - 1, buf, to, _from)

        hanoi_recursion(self.disc_count, self.pin1, self.pin3, self.pin2)


n = 25

tower = HanoiTower(n)
print(tower)
now = datetime.datetime.now()

tower.move_all_as_cycle()

print(datetime.datetime.now()-now)
# tower = HanoiTower(n)
# now = datetime.datetime.now()
# tower.move_all_as_recursion()
# print(datetime.datetime.now() - now)

"""

n = 3

    ━━━━━                        
   ━━━━━━━                       
  ━━━━━━━━━                      
═══════════════════════════════════

                                 
   ━━━━━━━                       
  ━━━━━━━━━               ━━━━━  
═══════════════════════════════════

                                 
                                 
  ━━━━━━━━━   ━━━━━━━     ━━━━━  
═══════════════════════════════════

                                 
               ━━━━━             
  ━━━━━━━━━   ━━━━━━━            
═══════════════════════════════════

                                 
               ━━━━━             
              ━━━━━━━   ━━━━━━━━━
═══════════════════════════════════

                                 
                                 
    ━━━━━     ━━━━━━━   ━━━━━━━━━
═══════════════════════════════════

                                 
                         ━━━━━━━ 
    ━━━━━               ━━━━━━━━━
═══════════════════════════════════

                          ━━━━━  
                         ━━━━━━━ 
                        ━━━━━━━━━
═══════════════════════════════════


n = 30

recursion  =  2**30/2796202.66 = 0:06:24
cycle      =  2**30/1118481.06 = 0:16:00

сложность оказалась 2^n,
только после написания рекурсии я понял почему такая сложность

"""
