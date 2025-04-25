package by.epam.number.service;

import by.epam.number.dto.NumbersDTO;
import by.epam.number.exception.NumbersDoesNotExistException;
import by.epam.number.model.Numbers;
import by.epam.number.repository.NumbersRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

import static by.epam.number.mapper.NumbersMapper.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class NumbersServiceImpl implements NumbersService {

    private final NumbersRepository numbersRepository;

    @Override
    public Collection<NumbersDTO> numbersFindAll() {
        return toListDTO(numbersRepository.findAll());
    }

    @Override
    public NumbersDTO numbersCreate(NumbersDTO numbersDTO) {
        Numbers numbers = toModel(numbersDTO);
        return toDTO(numbersRepository.save(numbers));
    }

    @Override
    public NumbersDTO numbersUpdate(NumbersDTO newNumbersDTO) {
        try {
            Numbers oldNumbers = numbersRepository
                    .findById(newNumbersDTO.getId())
                    .orElseThrow();
            oldNumbers.setNumbers(newNumbersDTO.getNum());
            numbersRepository.save(oldNumbers);
            return toDTO(oldNumbers);
        } catch (RuntimeException e) {
            throw new NumbersDoesNotExistException("Введите правильно:id, цифру");
        }
    }

    @Override
    public Optional<NumbersDTO> numbersFindById(long id) {
        return Optional.of(toDTO(numbersRepository
                .findById(id)
                .orElseThrow(() -> new NumbersDoesNotExistException("Цифра не найдена."))));
    }

    @Override
    public void numbersDeleteById(long id) {
        numbersRepository.deleteById(id);
    }

    @Override
    public String taskA1() {
        String result;
        try {
            if (numbersRepository.findAll().isEmpty()) {
                throw new NumbersDoesNotExistException("Заполните список.");
            }
            List<Numbers> list = numbersRepository.findAll()
                    .stream()
                    .sorted((a, b) -> a.getNumbers() - b.getNumbers())
                    .toList();

            result = "1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.\n";

            int min = list.getFirst().getNumbers();
            int minLength = String.valueOf(min).length();
            result += "min=" + min + " length=" + minLength + "\n";

            int max = list.getLast().getNumbers();
            int maxLength = String.valueOf(max).length();
            result += "max=" + max + " lemgth=" + maxLength + "\n";

            log.info("Вывод задачи taskA1()");

            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Заполните список.";
    }

    @Override
    public String taskA2() {
        String result;
        int lineSize = 10;
        try {
            if (numbersRepository.findAll().isEmpty()) {
                throw new NumbersDoesNotExistException("Заполните список.");
            }
            result = "2. Упорядочить и вывести числа в порядке возрастания (убывания) значений их длины.\n";
            result += "В порядке возрастания значений:\n";
            result += show(numbersRepository.findAll().stream().sorted((a, b) -> a.getNumbers() - b.getNumbers()).toList(), result, lineSize);

            result += "\nВ порядке убывания значений:\n";
            result += show(numbersRepository.findAll().stream().sorted((a, b) -> b.getNumbers() - a.getNumbers()).toList(), result, lineSize);

            log.info("Вывод задачи taskA1()");

            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Заполните список.";
    }

    @Override
    public String taskA3() {
        String result;
        int lineSize = 10;
        try {
            if (numbersRepository.findAll().isEmpty()) {
                throw new NumbersDoesNotExistException("Заполните список.");
            }
            result = "3. Вывести на консоль те числа, длина которых меньше (больше) средней, а также длину.\n";
            int sum = numbersRepository.findAll().stream().mapToInt(Numbers::getNumbers).sum();
            result += "Числа меньше средней:\n";
            result += show(numbersRepository.findAll()
                            .stream()
                            .filter(i -> i.getNumbers() > sum / numbersRepository.findAll().size())
                            .toList()
                    , result, lineSize);
            result += "\nЧисла больше средней:\n";
            result += show(numbersRepository.findAll()
                            .stream()
                            .filter(i -> i.getNumbers() < sum / numbersRepository.findAll().size())
                            .toList()
                    , result, lineSize);
            return result;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Заполните список.";
    }

    @Override
    public String taskA4() {
        String result;
        int lineSize = 10;
        try {
            if (numbersRepository.findAll().isEmpty()) {
                throw new NumbersDoesNotExistException("Заполните список.");
            }
            result = "4. Найти число, в котором число различных цифр минимально. Если таких " +
                    "чисел несколько, найти первое из них.(число из 6 цифр)\n";
            @Getter
            class Num {
                private final Long id;
                private final Integer num;
                private final Integer various;

                Num(Long id, Integer num, Integer various) {
                    this.id = id;
                    this.num = num;
                    this.various = various;
                }

                @Override
                public String toString() {
                    return id + "/" + num + "/" + various;
                }
            }
            List<Num> nums = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (Numbers numbers : numbersRepository.findAll()) {
                String[] line = String.valueOf(numbers.getNumbers()).split("");

                for (String s : line) {
                    if (!map.containsKey(Integer.parseInt(s))) {
                        map.put(Integer.parseInt(s), 1);
                    } else {
                        map.put(Integer.parseInt(s), map.get(Integer.parseInt(s)) + 1);
                    }
                }
                System.out.println(numbers.getNumbers());
                int count = 0;
                for (Integer value : map.values()) {
                    count++;
                }
                System.out.println(count);
                nums.add(new Num(numbers.getId(), numbers.getNumbers(), count));
                map.clear();
            }
            result += "id/number/various\n";
            int size = 6;
            List<Num> nums1 = nums
                    .stream()
                    .filter(i -> String.valueOf(i.getNum()).length() == size)
                    .sorted((a, b) -> b.getNum() - a.getNum())
                    .sorted((a, b) -> a.getVarious() - b.getVarious())
                    .toList();
            result += nums1.getFirst().toString() + "\n";
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Заполните список.";
    }

    @Override
    public String taskA5() {
        String result;
        int lineSize = 10;
        try {
            if (numbersRepository.findAll().isEmpty()) {
                throw new Exception("Заполните список.");
            }
            result = "5. Найти количество чисел, содержащих только четные цифры, а среди них —" +
                    "  количество чисел с равным числом четных и нечетных цифр.\n";
            show(numbersRepository.findAll()
                            .stream()
                            .filter((i) -> {
                                        String[] line = String.valueOf(i.getNumbers()).split("");
                                        int sum1 = 0;
                                        int sum2 = 0;
                                        for (String s : line) {
                                            if (Integer.parseInt(s) % 2 == 0) {
                                                ++sum1;
                                            }
                                            if (Integer.parseInt(s) % 2 != 0) {
                                                ++sum2;
                                            }
                                        }
                                        return sum1 == sum2 && i.getNumbers() % 2 == 0;
                                    }
                            )
                            .toList()
                    , result, lineSize);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "Заполните список.";
    }

    @Override
    public String taskA6() {
        return "";
    }

    @Override
    public String taskA7() {
        return "";
    }

    @Override
    public String taskA8() {
        return "";
    }

    @Override
    public String taskA9() {
        return "";
    }


    private String show(List<Numbers> list, String result, int lineSize) {
        int count = 0;
        result += "Вывод: number/length\n";
        for (Numbers numbers : list) {
            result += "\t" + numbers.getNumbers() + "/" + String.valueOf(numbers.getNumbers()).length();
            count++;
            if (count == lineSize) {
                result += "\n";
                count = 0;
            }
        }
        return result;
    }
}