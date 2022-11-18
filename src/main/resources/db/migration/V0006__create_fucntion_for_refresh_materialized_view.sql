
/*Данная фукнция является триггерной и запускает обновление MATERIALIZED VIEW. Для нее еще будет
  создан триггер.
  Триггерные функции всегда объявляются как « RETURNS trigger
 REFRESH MATERIALIZED VIEW - полностью заменяет содержимое материализованного представления.
  Эту команду разрешено выполнять только владельцам мат. представления.

CONCURRENTLY - Обновить материализованное представление, не блокируя параллельные выборки из него.
  Без данного параметра обновление, затрагивающее много строк, обычно задействует
  меньше ресурсов и выполнится быстрее, но может препятствовать чтению
  этого материализованного представления другими сеансами.
  При этом данный режим может быть быстрее при небольшом количестве строк.

Данный параметр допускается, только, если в материализованном представлении
  есть хотя бы один индекс UNIQUE, построенный только по именам столбцов и
  включающий все строки (то есть это не должен быть индекс по выражению или индекс,
  содержащий WHERE).

  Этот параметр нельзя использовать,
  когда материализованное представление ещё не наполнено.

   Даже с этим параметром в один момент времени допускается
  только одно обновление (REFRESH) материализованного представления.
  */
CREATE OR REPLACE FUNCTION refresh_materialized_view()
    RETURNS TRIGGER LANGUAGE plpgsql
AS $$
BEGIN
    REFRESH MATERIALIZED VIEW CONCURRENTLY purchase_order_summary;
    RETURN NULL;
END $$;
