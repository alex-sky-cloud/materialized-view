/*Данный триггер будет запущен, как только в таблицу purchase_orders,
  будет вставлена очередная запись. После этого, данный триггер запустит
  триггерную фукнцию, которая в свою очередь запустит обновление materialized view*/
CREATE TRIGGER refresh_mat_view_after_insert_into_purchase_orders
    AFTER INSERT
    ON purchase_orders
    FOR EACH STATEMENT
EXECUTE PROCEDURE refresh_materialized_view();