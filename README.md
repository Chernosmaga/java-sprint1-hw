# Постановка задачи
Компания по производству спортивных носков решила разработать собственный счётчик калорий для дополнительной мотивации к здоровому образу жизни. Написать прототип приложения поручили вам. Он будет работать в консоли и демонстрировать основные функции будущего приложения.

### Приложение должно предоставлять следующую функциональность:

* консольный интерфейс для управления программой;
* хранение данных о количестве пройденных шагов за несколько месяцев;
* ввод цели по количеству шагов в день;
* ввод пройденного количества шагов за день;
* вывод статистики за определённый месяц.

### Алгоритм решения

### Шаг 0

Для начала разберёмся, что будет нужно учесть при создании прототипа приложения. Определите архитектуру и приёмы будущего решения.

* Ввод пройденного количества шагов за день
Запрашивать номер месяца, день и количество шагов, сохранять количество шагов в соответствующую переменную.
* Консольный интерфейс для управления программой
  В бесконечном цикле выводить меню с возможными операциями ввода/вывода из заявленной функциональности.
* Вывод статистики за определённый месяц
  Запрашивать номер месяца, считать для него данные для статистики, выводить эти данные на экран.
* Ввод цели по количеству шагов в день
  Записывать число в отдельную переменную, использовать её при подсчёте статистики.
* Хранение данных о количестве пройденных шагов за несколько месяцев
  Запись результатов в определённую упорядоченную структуру данных.

### Шаг 1

В среде разработки IntelliJ IDEA откройте проект java-sprint1-hw,  который вы склонировали ранее.

### Шаг 2

В папке src проекта java-sprint1-hw создайте основной файл — класс Main.java с методом public static void main(String[] args). Вся работа с пользовательским вводом и выводом меню будет производиться в этом классе.

### Шаг 3

В методе main(String[] args) создайте экземпляр класса Scanner для считывания данных из консоли. Класс Scanner нужно предварительно импортировать.
Создайте цикл для непрерывного считывания номеров команд.

### Шаг 4

Пользователь взаимодействует с приложением через консольный интерфейс, который позволяет произвести одно из действий по выбору:

* ввести количество шагов за определённый день;
*  изменить цель по количеству шагов в день;
* напечатать статистику за определённый месяц;
* выйти из приложения.

Реализуйте печать меню через метод static void printMenu(). Добавьте вызов этого метода в цикл.
Программа должна завершаться только при вводе пользователем команды выхода. При вводе несуществующей команды должно выводиться сообщение, что такой команды нет. После чего приложение позволит снова выбрать следующее действие. Формат сообщений вы выбираете сами.
Реализуйте логику ввода команды и соответствующей реакции на неё. Так как логика для команд 1, 2, 3 на этом этапе отсутствует, при их вводе можно выводить служебное сообщение вида: «Выполняется команда 1».

### Шаг 5

В папке src проекта java-sprint1-hw создайте файл MonthData.java. В нём будут храниться данные конкретного месяца и логика по подсчёту статистики.
По условию задачи, шаги пользователя нужно учитывать каждый день. Это значит, что  требуется хранить данные в некоторой последовательности, а обращаться к данным определённого дня по индексу. Один из способов это сделать — воспользоваться массивом.
Создайте поле days с типом «целочисленный массив» и проинициализируйте его. Для прототипа достаточно указать, что в любом месяце ровно 30 дней.

### Шаг 6

В папке src проекта java-sprint1-hw создайте файл StepTracker.java. В нём будет реализована логика по сохранению и изменению количества шагов. Также в нём будет выводиться статистика.
Как и в предыдущем пункте, необходимо с помощью массива связать номер месяца и его данные. В качестве индекса нужно указать порядковый номер месяца. В таком случае 0 будет обозначать январь, а 6 — июль, так как индексы элементов массива начинаются с нуля, а не с единицы.
Добавьте поле monthToData c типом «массив объектов класса MonthData» и присвойте ему пустой массив с размером в 12 элементов.
Для команды по сохранению количества шагов потребуется дополнительный ввод с клавиатуры. Поэтому в класс StepTracker также необходимо добавить поле с типом Scanner. Чтобы не создавать новый экземпляр Scanner, добавьте конструктор класса StepTracker, принимающий соответствующий аргумент.
В конструкторе также необходимо создать новый экземпляр класса MonthData для каждого индекса массива monthToData.

### Шаг 7

В классе StepTracker реализуйте метод void addNewNumberStepsPerDay(). При вызове метода необходимо принимать с консоли номер месяца, номер дня и количество шагов. 

Проверьте необходимые условия:

* номер вводимого месяца должен быть от 1 до 12 включительно;
* номер вводимого дня должен быть от 1 до 30 включительно;
* количество шагов должно быть положительным числом.

Если какое-то условие не выполнено, необходимо вывести об этом сообщение на экран и завершить выполнение метода.
Если все условия выполнены необходимо сохранить полученные данные. Для этого из массива monthToData получите уже созданный объект класса MonthData. Чтобы это сделать, нужно вычислить соответствующий индекс. Так как индексы в массиве начинаются с 0, а номер месяца — с 1, то для вычисления индекса необходимо вычесть 1 от указанного номера месяца. Затем сохраните количество шагов в массиве days, полученного объекта MonthData. Для этого также нужно будет вычислить индекс на основе номера дня.
В классе Main  добавьте создание экземпляра StepTracker в начало метода main(..) до бесконечного цикла с меню и вызов метода addNewNumberStepsPerDay() при вводе соответствующей команды.

### Шаг 8

Заведите в StepTracker поле goalByStepsPerDay, отвечающее за цель шагов на день. Значение поля по умолчанию равно 10 000. Создайте метод void changeStepGoal(), который будет менять это значение на вводимое пользователем. Не забудьте обработать случай, когда пользователь вводит меньшее или равное нулю число в качестве цели. Добавьте вызов этого метода в метод main(..).

### Шаг 9

Реализуйте подсчёт статистики за месяц. В неё должны входить следующие пункты.

* количество пройденных шагов по дням в формате:
1 день: 3000
2 день: 2000
...
30 день: 10000
* общее количество шагов за месяц;
*  максимальное количество шагов в месяце;
*  лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.

Для этого в классе MonthData создайте следующие методы:
* void printDaysAndStepsFromMonth(): вывод на экран элементов массива в необходимом формате. Не забывайте, что индексы в массиве начинаются с нуля, а дни — с единицы.
* int sumStepsFromMonth(): подсчёт суммы шагов за месяц. Метод должен возвращать сумму элементов массива days[].
* int maxSteps(): максимальное количество шагов за месяц. Метод должен возвращать максимальный элемент массива days[].
* int bestSeries(int goalByStepsPerDay): поиск максимальной серии. Метод должен возвращать максимальное количество подряд идущих элементов days[], больших или равных goalByStepsPerDay.

### Шаг 10

В папке src проекта java-sprint1-hw создайте файл Converter.java.
В этом классе будет осуществляться преобразование шагов в километры и килокалории. При этом:

* для подсчёта дистанции можно считать, что один шаг равен 75 см;
* для подсчёта количества сожжённых килокалорий можно считать, что 1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.

Создайте следующие методы:
* int convertToKm(int steps): метод, переводящий количество шагов в километры;
* int convertStepsToKilocalories(int steps): метод, переводящий количество шагов в килокалории.

Поскольку числа, с которыми будет работать приложение, достаточно велики, можно использовать тип int и целочисленную арифметику (например, деление без остатка).  Количество энергии измеряется в тысячах калорий, а человек проходит в день в среднем несколько тысяч шагов, поэтому точность работы с вещественными значениями меньше единицы в этом приложении не требуется.

### Шаг 11

Реализуйте вывод статистики при вводе соответствующей команды.
Для этого создайте метод void printStatistic() в классе StepTracker, который будет ожидать ввода номера месяца и выводить на экран следующие данные:
* количество пройденных шагов по дням;
* общее количество шагов за месяц;
* максимальное пройденное количество шагов в месяце;
* среднее количество шагов;
* пройденная дистанция (в км);
* количество сожжённых килокалорий;
* лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.

Для расчета дистанции и килокалорий необходимо добавить в класс StepTracker поле с типом Converter, которое также необходимо проинициализировать.
Не забудьте добавить вызов printStatistic() в метод main(..) для соответствующей команды.

### Шаг 12

Скомпилируйте готовую программу с помощью кнопки Build Project в IntelliJ IDEA. Если проект не соберётся, внимательно изучите ошибки в консоли. Файл, строка и суть проблемы могут подсказать, в чём именно ошибка. После исправления ошибок скомпилируйте проект снова. В случае удачной сборки проекта запустите программу с помощью кнопки Run.

### Шаг 13

Протестируйте работу своего приложения. В консоли введите тестовые данные и проверьте, как реагирует приложение. Соответствует ли поведение прототипа ожидаемой функциональности.