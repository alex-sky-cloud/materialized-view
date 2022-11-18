create view purchase_order_summary
as
select u.state,
       sum(p.price) as total_sale
from users u,
     products p,
     purchase_orders po
where u.id = po.user_id
  and p.id = po.product_id
group by u.state
order by u.state
